package vn.molu.converter;

import org.springframework.stereotype.Component;
import vn.molu.dto.NewDTO;
import vn.molu.entity.NewEntity;

@Component /*Cở chế Dependency*/
public class NewConverter {

	public NewDTO toDto(NewEntity entity) {   /*Converter from entity to dto*/
		NewDTO result = new NewDTO();
		result.setId(entity.getId()); /*Từ entity qua dto chăn chắc có còn từ dto qua entity có thể k có ví dụ thêm mới không có id*/
		result.setTitle(entity.getTitle());
		result.setShortDescription(entity.getShortDescription());
		result.setContent(entity.getContent());
		result.setThumbnail(entity.getThumbnail());
		result.setCategoryCode(entity.getCategory().getCode());
		return result;
	}
	
	public NewEntity toEntity(NewDTO dto) {   /*Ngược lại from dto to entity*/
		NewEntity result = new NewEntity();
		result.setTitle(dto.getTitle());
		result.setShortDescription(dto.getShortDescription());
		result.setContent(dto.getContent());
		result.setThumbnail(dto.getThumbnail());
		return result;
	}
	
	public NewEntity toEntity(NewEntity result, NewDTO dto) {
		result.setTitle(dto.getTitle());
		result.setShortDescription(dto.getShortDescription());
		result.setContent(dto.getContent());
		result.setThumbnail(dto.getThumbnail());
		return result;
	}
}
