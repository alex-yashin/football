(ns football.core)

(defn sign [firstTeamResult secondTeamResult]
    (cond 
        (< firstTeamResult secondTeamResult) -1
        (> firstTeamResult secondTeamResult) 1
        (= firstTeamResult secondTeamResult) 0))

(defn score [realScore userScore]
    (if (= realScore userScore) 
        2
        (let [[_ realFirstTeamResult realSecondTeamResult] (re-matches #"(\d+):(\d+)" realScore)
            [_ userFirstTeamResult userSecondTeamResult] (re-matches #"(\d+):(\d+)" userScore)]
                (if (= (sign (Integer. realFirstTeamResult) (Integer. realSecondTeamResult)) 
                       (sign (Integer. userFirstTeamResult) (Integer. userSecondTeamResult))) 
                            1 0))))

    
(defn -main [& args]
    (do 
        (println (score "1:2" "1:2"))
        (println (score "1:2" "3:4"))
        (println (score "1:2" "1:3"))
        (println (score "5:2" "3:4"))
    ))