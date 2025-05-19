package com.ponsun.aml.counterfeit.CounterfeitNumber.api;

import com.ponsun.aml.infrastructure.utils.Response;
import com.ponsun.aml.counterfeit.CounterfeitNumber.domain.CounterfeitNumber;
import com.ponsun.aml.counterfeit.CounterfeitNumber.request.CreateCounterfeitNumberRequest;
import com.ponsun.aml.counterfeit.CounterfeitNumber.request.UpdateCounterfeitNumberRequest;
import com.ponsun.aml.counterfeit.CounterfeitNumber.services.CounterfeitNumberReadService;
import com.ponsun.aml.counterfeit.CounterfeitNumber.services.CounterfeitNumberWriteService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/v1/CounterfeitNumber")
@Tag(name = "CounterfeitNumberApiResources")
public class CounterfeitNumberApiResources {
    private final CounterfeitNumberWriteService counterfeitNumberWriteService;
    private final CounterfeitNumberReadService counterfeitNumberReadService;

    @PostMapping("/CreateCounterfeitNumberRequest")
    public Response createCounterfeitNumber(@RequestBody CreateCounterfeitNumberRequest createCounterfeitNumberRequest){
        Response response = this.counterfeitNumberWriteService.createCounterfeitNumber(createCounterfeitNumberRequest);
        return response;
    }
    @PutMapping("/{id}")
    public Response updateCounterfeitNumber(@PathVariable Integer id, @RequestBody UpdateCounterfeitNumberRequest updateCounterfeitNumberRequest){
        Response response = this.counterfeitNumberWriteService.updateCounterfeitNumber(id, updateCounterfeitNumberRequest);
        return response;
    }

    @GetMapping("/{id}")
    public CounterfeitNumber fetchCounterfeitNumberById(@PathVariable(name = "id")Integer id) {
        return this.counterfeitNumberReadService.fetchCounterfeitNumberById(id);
    }

    @GetMapping
    public List<CounterfeitNumber> fetchAll(){return this.counterfeitNumberReadService.fetchAllCounterfeitNumber();
    }

    @PutMapping("/{id}/deActivate")
    public Response deActivate(@RequestParam Integer counterfeitId, @RequestParam Integer euid){
        Response response = this.counterfeitNumberWriteService.deActive(counterfeitId,euid);
        return  response;
    }
}
