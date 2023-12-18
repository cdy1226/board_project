package org.zerock.dao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.zerock.w2.dao.TodoDAO;
import org.zerock.w2.domain.TodoVO;

import java.time.LocalDate;
import java.util.List;

public class TodoDAOTests {
    private TodoDAO todoDAO;

    @BeforeEach
    public void ready(){
        todoDAO = new TodoDAO();
    }
    @Test
    public void testTime() throws Exception{
        System.out.println(todoDAO.getTime());
    }

    @Test
    public void testTime2() throws Exception{
        System.out.println(todoDAO.getTime2());
    }

    @Test
    public void testInsert() throws Exception{
        TodoVO todoVO = TodoVO.builder()
                .title("Sample Title...")
                .dueDate(LocalDate.of(2023,9,13))
                .build();
        todoDAO.insert(todoVO);
    }

    @Test
    public void testList() throws Exception{
        List<TodoVO> list = todoDAO.selectAll();
        list.forEach(vo->System.out.println(vo));
    }

    @Test
    public void testSelectOne() throws Exception{
        Long tno = 5L;
        TodoVO vo = todoDAO.selectOne(tno);
        System.out.println(vo);
    }

    @Test
    public void testUpdateOne() throws Exception{
        TodoVO todoVO = TodoVO.builder()
                .tno(2L)
                .title("samsamsam")
                .dueDate(LocalDate.of(2024,01,01))
                .finished(true)
                .build();
        todoDAO.updateOne(todoVO);
    }

    @Test
    public void testDeleteOne() throws Exception{
        todoDAO.deleteOne(2L);
    }
}
