package com.stwy.org.tweetyprocessor.service.dto;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

@Data
@Valid
public class CreateCompanyRequestDto {

    @NotEmpty
    private String companySymbol;
}
