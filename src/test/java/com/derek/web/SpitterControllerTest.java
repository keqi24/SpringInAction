package com.derek.web;

import com.derek.AppConfig;
import com.derek.model.Spitter;
import com.derek.repository.SpitterRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;



/**
 * Created by qux on 20/8/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=AppConfig.class)
@WebAppConfiguration
public class SpitterControllerTest {


    @Autowired
    SpitterController mSpitterController;

    @Autowired
    ApplicationContext applicationContext;

    @Test
    public void testSpitterController() throws Exception {
        MockMvc mockMvc = standaloneSetup(mSpitterController).build();

        mockMvc.perform(post("/spitter/register")
                .param("username", "Derek")
                .param("password", "1234567890"))
                .andExpect(redirectedUrl("/spitter/Derek"));

    }

    @Test
    public void shouldShowRegiterationMap() throws Exception {
        SpitterController controller = new SpitterController();
        MockMvc mockMvc = standaloneSetup(controller).build();

        mockMvc.perform(get("/spitter/register"))
                .andExpect(view().name("registerForm"));

    }

    @Test
    public void shouldprocessRegistration() throws Exception {
        SpitterRepository mockRepository = mock(SpitterRepository.class);
        Spitter unsaved = new Spitter("keqi25@gmail.com", "Derek", "1234567890");
        Spitter saved = new Spitter(1000, "keqi25@gmail.com", "Derek", "1234567890");
        when(mockRepository.save(unsaved)).thenReturn(saved);

        SpitterController controller = new SpitterController();
        controller.setSpitterRepository(mockRepository);
        MockMvc mockMvc = standaloneSetup(controller).build();

        mockMvc.perform(post("/spitter/register")
                .param("username", "Derek")
                .param("password", "1234567890"))
                .andExpect(redirectedUrl("/spitter/Derek"));

        verify(mockRepository, atLeastOnce()).save(unsaved);

    }

    @Test
    public void shouldFailValidationWithNoData() throws Exception {

        SpitterRepository mockRepository = mock(SpitterRepository.class);


        SpitterController controller = new SpitterController();
        controller.setSpitterRepository(mockRepository);
        MockMvc mockMvc = standaloneSetup(controller).build();

        mockMvc.perform(post("/spitter/register")
                .param("username", "haha")
                .param("password", "123"))
                .andExpect(status().isOk())
                .andExpect(view().name("registerForm"))
                .andExpect(model().errorCount(1))
                .andExpect(model().attributeHasFieldErrors("spitter", "password"));
    }
}
