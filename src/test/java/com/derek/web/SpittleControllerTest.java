package com.derek.web;

import com.derek.model.Spittle;
import com.derek.repository.SpittleRepository;
import com.derek.web.exception.DuplicateSpittleException;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.view.InternalResourceView;

import java.util.ArrayList;
import java.util.List;

import static org.junit.matchers.JUnitMatchers.hasItems;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;


/**
 * Created by qux on 19/8/17.
 */
public class SpittleControllerTest {

    @Test
    public void shouldShowRecentSpittles() throws Exception {
        List<Spittle> expectedSpittles = createSpittleList(20);
        SpittleRepository mockRepository = mock(SpittleRepository.class);
        when(mockRepository.findSpittle(238900, 50)).thenReturn(expectedSpittles);
        when(mockRepository.findSpittle(Long.parseLong(SpittleController.MAX_ID_LONG), 20)).thenReturn(expectedSpittles);

        SpittleController controller = new SpittleController();
        controller.setSpittleRepository(mockRepository);

        MockMvc mockMvc = standaloneSetup(controller)
                .setSingleView(new InternalResourceView("/WEB-INF/views/spittles.jsp"))
                .build();

        mockMvc.perform(get("/spittles?max=238900&count=50"))
                .andExpect(view().name("spittles"))
                .andExpect(model().attributeExists("spittleList"))
                .andExpect(model().attribute("spittleList", hasItems(expectedSpittles.toArray())));

        mockMvc.perform(get("/spittles"))
                .andExpect(view().name("spittles"))
                .andExpect(model().attributeExists("spittleList"))
                .andExpect(model().attribute("spittleList", hasItems(expectedSpittles.toArray())));
    }

    @Test
    public void testSpittle() throws Exception {
        Spittle expectedSpittle = new Spittle(1000, "Hello", System.currentTimeMillis());
        SpittleRepository mockRepository = mock(SpittleRepository.class);
        when(mockRepository.findOne(1000)).thenReturn(expectedSpittle);

        SpittleController controller = new SpittleController();
        controller.setSpittleRepository(mockRepository);
        MockMvc mockMvc = standaloneSetup(controller).build();

        mockMvc.perform(get("/spittles/1000"))
                .andExpect(view().name("spittle"))
                .andExpect(model().attributeExists("spittle"))
                .andExpect(model().attribute("spittle", expectedSpittle));

    }

    @Test
    public void testSaveSpittleError() throws Exception {
        SpittleRepository mockRepository = mock(SpittleRepository.class);
        doThrow(new DuplicateSpittleException()).when(mockRepository).save(any(Spittle.class));

        SpittleController controller = new SpittleController();
        controller.setSpittleRepository(mockRepository);
        MockMvc mockMvc = standaloneSetup(controller).build();

        mockMvc.perform(post("/spittles")
                .param("message", "Hello World")
                )
                .andExpect(view().name("error/duplicate"));
    }

    @Test
    public void testSaveSpittle() throws Exception {
        SpittleRepository mockRepository = mock(SpittleRepository.class);

        SpittleController controller = new SpittleController();
        controller.setSpittleRepository(mockRepository);
        MockMvc mockMvc = standaloneSetup(controller).build();

        mockMvc.perform(post("/spittles")
                .param("message", "Hello World")
        )
                .andExpect(redirectedUrl("/spittles"));

        verify(mockRepository, atLeastOnce()).save(new Spittle(0, "Hello World", 0));
    }



    private List<Spittle> createSpittleList(int count) {
        List<Spittle> spittles = new ArrayList<Spittle>();
        for (int i =0; i<count; i++) {
            spittles.add(new Spittle(i, "Spittle " + i, System.currentTimeMillis()/1000L));
        }
        return spittles;
    }
}


