package vn.molu.api.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vn.molu.dto.NewDTO;
import vn.molu.service.INewService;


@RestController(value = "newAPIOfAdmin")   /*Khai báo API*/
public class NewAPI {

	@Autowired
	private INewService newService;

    @PostMapping("/api/new")
    public NewDTO createNew(@RequestBody NewDTO newDTO) {
		return newService.save(newDTO);
    }

    @PutMapping("/api/new")
    public NewDTO updateNew(@RequestBody NewDTO updateNew) {
		return newService.save(updateNew);
    }

    @DeleteMapping("/api/new")
    public void deleteNew(@RequestBody long[] ids) {
		newService.delete(ids);
    }
}
