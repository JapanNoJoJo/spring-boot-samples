package com.jojo.boot.springbootmdc.service;

import com.jojo.boot.springbootmdc.entity.Person;
import com.jojo.boot.springbootmdc.repository.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    // ロガーのインスタンスを作成
    private final Logger logger = LoggerFactory.getLogger(getClass());
    private final PersonRepository personRepository;

    // コンストラクタでリポジトリを初期化
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    // IDでPerson情報を検索するメソッド
    public Person findById(Integer id) {
        logger.info("ID【{}】の情報を取得する準備をしています", id);
        return this.personRepository.findById(id).orElse(null);
    }

    @Async
    public void task() {
        // 非同期タスクを実行
        logger.info("非同期タスクを実行します");
    }

}
