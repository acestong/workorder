package com.fea.project.model.publish.addess;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property ="code")
@Data
public class JsonOriginalString {

	private Integer code;
	private JsonString data;
}
