# alínea a)

No ficheiro `A_EmployeeRepositoryTest.java`:

**Exemplo 1:**
```java
assertThat(found).isNotNull().
    extracting(Employee::getName).isEqualTo(persistedAlex.getName());
```

**Exemplo 2:**
```java
assertThat(fromDb.getEmail()).isEqualTo(emp.getEmail());
```

# alínea b)
```
@Transactional
@AutoConfigureCache
@AutoConfigureDataJpa
@AutoConfigureTestDatabase
@AutoConfigureTestEntityManager
@ImportAutoConfiguration
```

# alínea c)
No ficheiro `B_EmployeeService_UnitTest.java`:

```java
@Mock
private EmployeeRepository employeeRepository;

(...)

Mockito.when(employeeRepository.findByName(john.getName())).thenReturn(john);
Mockito.when(employeeRepository.findByName(alex.getName())).thenReturn(alex);
Mockito.when(employeeRepository.findByName("wrong_name")).thenReturn(null);
```

# alínea d)
Comparado ao `@Mock`, o `@MockBean` acrescenta a capacidade de fazer _mock_ dos _beans_ de um Spring ApplicationContext.
