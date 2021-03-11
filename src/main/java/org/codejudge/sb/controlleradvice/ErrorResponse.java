package org.codejudge.sb.controlleradvice;


import javax.xml.bind.annotation.XmlRootElement;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@XmlRootElement(name = "error")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse {
	private String failure;
	private String reason;
} 