(ns football.core)
(require '[clojure.string :as str])

(defn getWinner [score]
    (let [[firstTeamResult secondTeamResult] (map bigint (str/split score #":"))]
        (cond
            (< firstTeamResult secondTeamResult) :secondTeam
            (> firstTeamResult secondTeamResult) :draw
            (= firstTeamResult secondTeamResult) :firstTeam
        )))

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