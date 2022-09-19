package com.atm.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.ToString;

@Data
@AllArgsConstructor
@Getter
@Builder(toBuilder = true)
@ToString
public class FindShortestPathDTO {

	int robotId;
	int startVertex;
	int destVertex;
	
}
