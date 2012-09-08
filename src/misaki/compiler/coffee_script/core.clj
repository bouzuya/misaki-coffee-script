(ns misaki.compiler.coffee-script.core
  (:use
    [misaki.util.file :only [has-extension? remove-extension]]
    [coffee-script.core :only [compile-coffee]])
  (:require
    [clojure.java.io :as cji]
    [misaki.server]
    [misaki.compiler.default.core]))

(defn is-coffee-script?
  [config file]
  (and (= (.getParentFile file)
          (cji/file (:template-dir config)
                    (:coffee-script-in-dir config)))
       (has-extension? ".coffee" file)))

(defn compile-coffee-script-file
  [config file]
  {:status true
   :filename (str (:coffee-script-out-dir config)
                  (remove-extension file))
   :body (compile-coffee (slurp file))})

(defn -extension
  []
  (cons :coffee (misaki.compiler.default.core/-extension)))

(defn -config
  [config]
  (merge {:coffee-script-in-dir "coffee/"
          :coffee-script-out-dir "js/"}
         (misaki.compiler.default.core/-config config)))

(defn -compile
  [config file]
  (if (is-coffee-script? config file)
    (compile-coffee-script-file config file)
    (misaki.compiler.default.core/-compile config file)))

(defn -main
  [& args]
  (apply misaki.server/-main args))

