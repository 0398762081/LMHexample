package vn.molu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vn.molu.converter.NewConverter;
import vn.molu.dto.NewDTO;
import vn.molu.entity.CategoryEntity;
import vn.molu.entity.NewEntity;
import vn.molu.repository.CategoryRepository;
import vn.molu.repository.NewRepository;
import vn.molu.service.INewService;

import java.util.ArrayList;
import java.util.List;

@Service
public class NewService implements INewService {

    @Autowired
    private NewRepository newRepository;

    @Autowired
	private CategoryRepository categoryRepository;

	@Autowired   /*Nhúng NewConverter vào để sử dụng*/
	private NewConverter newConverter;


    @Override
    public List<NewDTO> findAll(Pageable pageable) {
        List<NewDTO> models = new ArrayList<>();   /*Rồi mới bỏ vào DTO*/
        List<NewEntity> entities = newRepository.findAll(pageable).getContent();   /*Nguyên tắc khi lấy dữ liệu lên sẻ trả  về entity*/
        for (NewEntity item : entities) {
            NewDTO newDTO = newConverter.toDto(item);
            models.add(newDTO);
        }
        return models;
    }

    @Override
    public int getTotalItem() {
        return (int) newRepository.count();
    }

	@Override
	public NewDTO findById(long id) {
		NewEntity entity = newRepository.findOne(id);
		return newConverter.toDto(entity);   /*mapper chỉ conver từ resultSet vào model*/
	}

	@Override
//    *** Phải khai báo rất quan trọng nếu k có sẻ hỏng data
	@Transactional /*Khai báo Transactional của spring để thực hiện commit và rollback tự động*/
	public NewDTO save(NewDTO dto) {
		CategoryEntity category = categoryRepository.findOneByCode(dto.getCategoryCode());
		NewEntity newEntity = new NewEntity();
		if (dto.getId() != null) {
			NewEntity oldNew = newRepository.findOne(dto.getId());
			oldNew.setCategory(category);
			newEntity = newConverter.toEntity(oldNew, dto);
		} else {
			newEntity = newConverter.toEntity(dto);
			newEntity.setCategory(category);
		}
		return newConverter.toDto(newRepository.save(newEntity));
	}

	@Override
	@Transactional
	public void delete(long[] ids) {
		for (long id: ids) {
			newRepository.delete(id);
		}
	}
}
