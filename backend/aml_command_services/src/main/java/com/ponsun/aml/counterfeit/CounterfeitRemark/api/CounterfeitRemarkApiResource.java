package com.ponsun.aml.counterfeit.CounterfeitRemark.api;

import com.ponsun.aml.infrastructure.utils.Response;
import com.ponsun.aml.counterfeit.CounterfeitRemark.domain.CounterfeitRemark;
import com.ponsun.aml.counterfeit.CounterfeitRemark.request.CreateCounterfeitRemarkRequest;
import com.ponsun.aml.counterfeit.CounterfeitRemark.request.UpdateCounterfeitRemarkRequest;
import com.ponsun.aml.counterfeit.CounterfeitRemark.services.CounterfeitRemarkReadService;
import com.ponsun.aml.counterfeit.CounterfeitRemark.services.CounterfeitRemarkWriteService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/v1/CounterfeitRemark")
@Tag(name = "CounterfeitRemarkApiResources")
public class CounterfeitRemarkApiResource {

    private final CounterfeitRemarkWriteService counterfeitRemarkWriteService;
    private final CounterfeitRemarkReadService counterfeitRemarkReadService;
    @PostMapping("/CreateCounterfeitRemarkRequest")
    public Response createCounterfeitRemark(@RequestBody CreateCounterfeitRemarkRequest createCounterfeitRemarkRequest){
        Response response = this.counterfeitRemarkWriteService.createCounterfeitRemark(createCounterfeitRemarkRequest);
        return response;
    }
    @PutMapping("/{id}")
    public Response updateCounterfeitRemark(@PathVariable Integer id, @RequestBody UpdateCounterfeitRemarkRequest updateCounterfeitRemarkRequest){
        Response response = this.counterfeitRemarkWriteService.updateCounterfeitRemark(id, updateCounterfeitRemarkRequest);
        return response;
    }

    @GetMapping("/{id}")
    public CounterfeitRemark fetchCounterfeitRemarkById(@PathVariable(name = "id")Integer id) {
        return this.counterfeitRemarkReadService.fetchCounterfeitRemarkById(id);
    }

    @GetMapping
    public List<CounterfeitRemark> fetchAll(){return this.counterfeitRemarkReadService.fetchAllCounterfeitRemark();
    }

    @PutMapping("/{id}/deActivate")
    public Response deActivate(@RequestParam Integer counterfeitId, @RequestParam Integer euid){
        Response response = this.counterfeitRemarkWriteService.deActive(counterfeitId,euid);
        return  response;
    }
}
