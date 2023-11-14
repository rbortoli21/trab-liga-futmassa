package com.rafael.bortoli.service;

import com.rafael.bortoli.model.Clube;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.event.annotation.BeforeTestMethod;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class ClubeServiceTests {
    @Autowired
    ClubeService clubeService;

    @Test
    public void getAll(){
        assertNotNull(clubeService.getAll());
    }

    @Test
    public void salvarClube() {
        Clube clube = new Clube();

        clube.setNome("Palmeiras");

        clubeService.save(clube);

        assertNotNull(clubeService.findById(clube.getId()));
    }


    @Nested
    public class TestsForEditarClube {
        Clube clube = new Clube();

        @BeforeEach
        public void beforeEditar() {
            clube.setNome("Palmeiras");
            clubeService.save(clube);
        }

        @Test
        public void editarClube() {
            Clube newClube = new Clube();
            newClube.setNome("Palmeiras editado");

            clube = clubeService.edit(clube.getId(), newClube);

            assertEquals(clube.getNome(), newClube.getNome());
        }

    }

    @Nested
    public class TestsForDeletarClube {
        Clube clube = new Clube();

        @BeforeEach
        public void beforeDeletar() {
            clube.setNome("Palmeiras");
            clubeService.save(clube);
        }

        @Test
        public void deletarClube() {
            clubeService.delete(clube.getId());
            assertThrowsExactly(RuntimeException.class, () -> clubeService.findById(clube.getId()));
        }

    }

    @Nested
    public class TestsForGetById {
        Clube clube = new Clube();

        @BeforeEach
        public void beforeGetById() {
            clube.setNome("Palmeiras");
            clubeService.save(clube);
        }

        @Test
        public void getById() {
            assertNotNull(clubeService.findById(clube.getId()));
        }
    }

}
