(ns football.core)
(require '[clojure.string :as str])

(defn getWinner [score]
    (let [[firstTeamResultStr secondTeamResultStr] (str/split score #":")]
        (let 
            [firstTeamResult (bigint firstTeamResultStr)
             secondTeamResult (bigint secondTeamResultStr)]
            (cond
                (< firstTeamResult secondTeamResult) :secondTeam
                (> firstTeamResult secondTeamResult) :draw
                (= firstTeamResult secondTeamResult) :firstTeam
            ))))

(defn score [realScore userScore]
    (cond 
        (= realScore userScore) 2
        (= (getWinner realScore) (getWinner userScore)) 1
        :else 0))
    
(defn -main [& args]
    (do 
        (println (score "1:2" "1:2"))
        (println (score "1:2" "3:4"))
        (println (score "1:2" "1:3"))
        (println (score "5:2" "3:4"))))