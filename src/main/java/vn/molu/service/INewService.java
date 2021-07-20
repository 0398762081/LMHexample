package vn.molu.service;

import org.springframework.data.domain.Pageable;
import vn.molu.dto.NewDTO;

import java.util.List;

public interface INewService {

    List<NewDTO> findAll(Pageable pageable);

    int getTotalItem();
	NewDTO findById(long id);
	NewDTO save(NewDTO dto);
	void delete(long[] ids);
}
