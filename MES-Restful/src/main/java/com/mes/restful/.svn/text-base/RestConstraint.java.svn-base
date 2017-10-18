package com.mes.restful;

import com.mes.common.framework.rest.view.JsonViewObject;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import java.util.Set;

public class RestConstraint implements ExceptionMapper<ConstraintViolationException> {


	public Response toResponse(ConstraintViolationException arg0) {
		Set<ConstraintViolation<?>> violations = arg0.getConstraintViolations();
		StringBuilder sb = new StringBuilder();
		for(ConstraintViolation<?> violation : violations) {
			sb.append("," + violation.getMessage());
		}
		if(sb.length() > 0) {
			sb.deleteCharAt(0);
		}
		JsonViewObject jsonViewObject = new JsonViewObject();
		jsonViewObject.failPack(sb.toString());
		return Response.status(400).entity(jsonViewObject).type(MediaType.APPLICATION_JSON).build();
	}

}
