# Requisiti
### Regole del gioco base
Si vuole realizzare il gioco da tavolo Santorini utilizzando il linguaggio di programmazione Java in versione WebApp, da poter giocare in rete locale da più persone. 
Il gioco, per 2 o 4 persone massimo, si svolge su una board di grandezza 5x5 caselle.
Ogni giocatore, nella versione 1v1 del gioco, controlla due worker a testa. Nella versione 2v2 ogni giocatore ne controlla solamente uno, non per forza lo stesso ad ogni turno. 
All'inizio di un turno ogni giocatore ha la possibilita di muovere un worker in una delle 8 caselle adiacenti a lui purchè non sia occupata da un altro worker o da una cupola. Un worker non può muoversi verso una costruzione con più di un livello di disparità in salita, mentre verso il basso può scendere sempre indipendentemente dal dislivello.
Dopo essersi mosso il worker può decidere di costruire un block nelle 8 caselle circostanti a lui che non siano già occupate da altri worker o che non abbiano già una cupola costruita. Un worker può costruire una cupola solo sopra un edificio costituito da 3 block.
Un giocatore vince quanto il worker arriva in cima a un edificio costituito da 3 block, oppure perde se tutti i suoi worker non hanno più mosse a disposizione. 
### God powers
Verranno implementati nel programma anche i God Powers, delle modificazioni che avverrano prima o durante il gioco, che saranno scelti all'inizio di ogni partita. Non può essere giocata una partita con due God Powers uguali (per rimanere fedeli al gioco in scatola).