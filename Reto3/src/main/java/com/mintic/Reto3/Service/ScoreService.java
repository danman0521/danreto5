package com.mintic.Reto3.Service;

import com.mintic.Reto3.Model.Score;
import com.mintic.Reto3.Repository.ScoreRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScoreService {
    
    @Autowired
    private ScoreRepository scoreRepository ;
    
    
    public List<Score> getScoreAll(){
        return scoreRepository.getScoreAll();
        }
    public Optional <Score> getScoreId(Integer id){
        return scoreRepository.getScoreId(id);
    }
    
    public Score saveScore (Score score){
        if (score.getIdScore()==null){
            return scoreRepository.saveScore(score);
        }else{
           Optional <Score> scoreAuxiliar = scoreRepository.getScoreId(score.getIdScore());
           if(scoreAuxiliar.isEmpty()){
           return scoreRepository.saveScore(score);
           }else{
           return score;
           }
        }
    } 
    
}
