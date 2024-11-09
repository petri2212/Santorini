# Regole di Santorini (godless)

## Setup

- Inizia il giocatore più piccolo (nel nostro caso scelto randomicamente) a posizionare due worker in un qualsiasi spazio non occupato della board, seguito dal secondo giocatore che farà lo stesso.

## Terminologia

- **Worker**: il pippottino che i giocatori muoveranno e con cui costruiranno. Ogni giocatore ne ha due a testa (in 1v1)
- **Board**: la tavola del gioco in sé, 5x5
- **Block** o **Dome**: i segmenti degli edifici del gioco. La _dome_ (cupola) può essere piazzata solo sopra gli edifici composti da 3 _blocks_
- **Edificio**: ogni edificio parte dal livello (altezza) 0 e ha una altezza massima di 3. Se su un edificio di 3 _blocks_ è stata posiziona una _dome_ i worker non ci potranno salire per vincere il gioco

## Come giocare

- In ogni turno il giocatore sceglierà solo uno tra i suoi worker, lo dovrà muovere e solo dopo costruire con lo stesso.

- ### Muoversi

  - Il worker si può muovere nelle 8 caselle adiacenti a sé che non siano occupati da un altro worker o una _dome_ (cupola)
  - Il worker può muoversi verso l'alto di solo un livello alla volta (non può salire due livelli in un solo turno)
  - Il worker può sempre muoversi verso il basso, indipendentemente da quanti livelli deve passare

- ### Costruire

  - Si può costruire un _block_ o una _dome_ in una delle 8 caselle adiacenti e libere da altri lavoratori attorno al lavoratore appena mosso. Si può costruire una _dome_ solo sopra un edificio composto da 3 _blocks_
  - Una torre di 3 _blocks_ e una _dome_ in cima viene chiamata _Complete Tower_ (Torre Completa)

## Condizione di vittoria

* Se un worker arriva ad altezza 3 il suo rispettivo giocatore vince
* Un giocatore deve sempre avere un worker capace di muoversi di una casella, altrimenti ha perso

## Componenti 

* 6 workers (3 coppie dello stesso colore)

* 18 _dome_

* 22 _block livello 1_

* 18 _block livello 2_

* 14 _block livello 3_
