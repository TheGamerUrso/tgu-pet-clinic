package thegamerurso.springframework.tgupetclinic.controllers;

import static org.mockito.Mockito.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import thegamerurso.springframework.tgupetclinic.model.Owner;
import thegamerurso.springframework.tgupetclinic.services.OwnerService;

@ExtendWith(SpringExtension.class)
public class OwnerControllerTest {

    @Mock
    OwnerService ownerService;

    @InjectMocks
    OwnerController controller;

    Set<Owner> owners;

    MockMvc mockMvc;

    @BeforeEach
    void setUp(){
        owners = new HashSet<>();
        owners.add((Owner.builder().Id(1l).build()));
        owners.add(Owner.builder().Id(2l).build());

        mockMvc = MockMvcBuilders
        .standaloneSetup(controller)
        .build();
     }

    @Test
    void findOwners() {
        mockMvc.perform(get("/owners/find"))
        .andExpect(status().isOk())
        .andExpect(view().name("notimplemented"));
    }

    @Test
    void listOwner() {
        when(ownerService.findAll()).thenReturn(owners);
        mockMvc.perform(get("/owners"))
        .andExpect(status().isOk())
        .andExpect(view().name("owners/Index"))
        .andExpect(model().attribute("owners",HasSize(2)));
    }


}
