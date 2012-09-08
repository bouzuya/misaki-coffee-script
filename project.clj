(defproject misaki-coffee-script "0.1.1"
  :description "misaki-coffee-script is one of misaki's compiler plugin using clj-coffee-script."
  :url "https://github.com/bouzuya/misaki-coffee-script"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.4.0"]
                 [clj-coffee-script "1.1.0"]
                 [misaki "0.2.1-beta"]]
  :main misaki.compiler.coffee-script.core)

