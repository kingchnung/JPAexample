package com.spring.client.board.repository;

import com.spring.client.board.domain.Board;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest
@Slf4j
public class BoardRepositoryTests {

    @Autowired
    private BoardRepository boardRepository;

    @Test
    public void boardInsertTest() {
//        Board board = Board.builder()
//                .name("늘한봄")
//                .title("노력 명언")
//                .content("우리 인생은 우리들이 노력한만큼 가치가 있다.")
//                .regDate(LocalDateTime.now())
//                .build();
//        log.info("### board 테이블에 첫번째 데이터 입력");
//        boardRepository.save(board);
//
//        Board board1 = Board.builder()
//                .name("홍길동")
//                .title("끈기 명언")
//                .content("강해서 살아남는게 아니라 살아남아서 강한거다.")
//                .regDate(LocalDateTime.now())
//                .build();
//        log.info("### board 테이블에 두번째 데이터 입력");
//        boardRepository.save(board1);
//
//        Board board2 = Board.builder()
//                .name("강희수")
//                .title("끈기 명언")
//                .content("단 한번의 노력으로 자기의 바람을 성취할 수 없다.")
//                .build();
//        log.info("### board 테이블에 세 번째 데이터 입력");
//        boardRepository.save(board2);
//
//        Board board3 = Board.builder()
//                .name("왕찬웅")
//                .title("왕찬웅 일대기")
//                .content("왕찬웅 그는 누구인가....")
//                .build();
//        log.info("### board 테이블에 네 번째 데이터 입력");
//        boardRepository.save(board3);

        Board board4 = new Board();
        board4.setName("강희수");
        board4.setTitle("언어 명언");
        board4.setContent("말이 입힌 상처는 칼이 입힌 상처보다 깊다.");

        log.info("### board 테이블에 다섯 번째 데이터 입력");
        boardRepository.save(board4);
    }

    @Test
    public void boardCountTest() {
        long boardCount = boardRepository.count();
        log.info("레코드 수 : {}", boardCount);
    }

    @Test
    public void voardListTest() {
        List<Board> boardList = (List<Board>) boardRepository.findAll();
        boardList.forEach(board -> log.info(board.toString()));
    }

    @Test
    public void boardDetailTest() {
        Optional<Board> boardOptional = boardRepository.findById(1L);

//        if(boardOptional.isPresent()) {
//            Board board = boardOptional.get();
//            log.info("1번글의 데이터 : {}", board);
//        }

        boardRepository.findById(1L).ifPresent(board -> log.info("데이터 확인 : {}", board));
        boardRepository.findById(7L).ifPresentOrElse(
                board -> log.info("데이터 확인 : {}", board),
                () -> log.info("데이터 없음"));
    }

    @Test
    public void boardUpdateTest() {
        Optional<Board> boardOptional = boardRepository.findById(4L);

//        if(boardOptional.isPresent()) {
//            Board board = boardOptional.get();
//            board.setHit(0);
//            boardRepository.save(board);
//        }
        boardOptional.ifPresentOrElse((board) -> log.info("기존의 데이터가 있을 때 수정"),
                () -> log.info("기존의 데이터가 없을 때 추가"));
    }

    @Test
    public void boardDeleteTest() {
        boardRepository.deleteById(5L);
    }

    @Test
    public void boardNotFoundTest() {
        Optional<Board> boardOptional = boardRepository.findById(9L);
        assertFalse(boardOptional.isPresent());
    }

    @Test
    public void findByTitleContainingTest() {
//        Board titleSearch = boardRepository.findByTitle("노력 명언");
//        log.info(titleSearch.toString());

        // 제목검색
//        List<Board> list = boardRepository.findByTitleContaining("끈기");
        // 이름검색
        //List<Board> list = boardRepository.findByNameContaining("한봄");
        // 내용검색
        //List<Board> list = boardRepository.findByContentContaining("소망");

        // 등록일검색
//    log.info(LocalDateTime.now().minusDays(2).toString());
//    log.info(LocalDateTime.now().toString());
    List<Board> list = boardRepository.findByRegDateBetween(LocalDateTime.now().minusDays(2), LocalDateTime.now());

        list.forEach(board -> log.info(board.toString()));
    }

    @Test
    public void boardAllInsertTest() {
        for(int i = 1; i <= 100; i++) {
            Board board = new Board();
            board.setTitle("Title..." + i);
            board.setName("홍길동" + i);
            board.setContent("실패한 자가 패배하는 것이 아니라 포기한 자가 패배하는 것이다.");
            boardRepository.save(board);
        }
    }
}

