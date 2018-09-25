package com.langpath.data.repositories;

import com.langpath.data.model.entity.word.Word;
import com.model_old.WorstAnsweredWord;
import com.model_old.enums.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

/**
 * Created by Sebastian on 2016-03-18.
 */
@Repository
@Transactional
public interface WordRepository extends JpaRepository<Word, Long> {

    Collection<Word> findByLang(Language lang);

    @Modifying
    @Query(value = "update Word w set w.wrongAnswers = w.wrongAnswers + 1 where w.id=?1")
    void increaseWrongAnswers(long id);

    @Query(value = "SELECT * from getWorstAnsweredWord(?1)", nativeQuery = true)
    WorstAnsweredWord getWorstUserWord(int userId);

/*
    public long wordGroupId;

    public long userId;

    public long wordId;

    public String valueWord;

    public int wrongAnswers;

SELECT t.tokenName FROM Role r JOIN r.tkns t WHERE r.roleId = :roleId



SELECT w.id wordId, wg.id wordGroupId, w.value valueWord, u.id userId, max(w.wronganswers) wrongAnswers
FROM public.word_group  wg
INNER JOIN public.usr_word_gr as uw
    ON wg.id = uw.word_group_id
INNER JOIN public.users as u
    ON uw.user_id = u.id
INNER JOIN public.word as w
    On w.wordgroupid = wg.id
WHERE u.id = 70782
GROUP BY wg.id,w.id,w.value, u.id;
 */

}
