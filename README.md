## Desafio do curso Java Spring Expert - DevSuperior

### Implementar camadas da API para que passe nos testes pré-setados:

```java
  @Test
	public void findAllShouldReturnAllResourcesSortedByName() throws Exception {
		
		ResultActions result =
				mockMvc.perform(get("/departments")
					.contentType(MediaType.APPLICATION_JSON));

		result.andExpect(status().isOk());
		result.andExpect(jsonPath("$[0].name").value("Management"));
		result.andExpect(jsonPath("$[1].name").value("Sales"));
		result.andExpect(jsonPath("$[2].name").value("Training"));
	}
```

```java
	@Test
	public void findAllShouldReturnPagedResourcesSortedByName() throws Exception {
		
		ResultActions result =
				mockMvc.perform(get("/employees")
					.contentType(MediaType.APPLICATION_JSON));

		result.andExpect(status().isOk());
		result.andExpect(jsonPath("$.content").exists());
		result.andExpect(jsonPath("$.content[0].name").value("Alex"));
		result.andExpect(jsonPath("$.content[1].name").value("Ana"));
		result.andExpect(jsonPath("$.content[2].name").value("Andressa"));
	}
	
	@Test
	public void insertShouldInsertResource() throws Exception {

		EmployeeDTO dto = new EmployeeDTO(null, "Joaquim", "joaquim@gmail.com", 1L);
		String jsonBody = objectMapper.writeValueAsString(dto);
		
		ResultActions result =
				mockMvc.perform(post("/employees")
					.content(jsonBody)
					.contentType(MediaType.APPLICATION_JSON)
					.accept(MediaType.APPLICATION_JSON));
		
		result.andExpect(status().isCreated());
		result.andExpect(jsonPath("$.id").exists());
		result.andExpect(jsonPath("$.name").value("Joaquim"));
		result.andExpect(jsonPath("$.email").value("joaquim@gmail.com"));
		result.andExpect(jsonPath("$.departmentId").value(1L));
	}	
```
