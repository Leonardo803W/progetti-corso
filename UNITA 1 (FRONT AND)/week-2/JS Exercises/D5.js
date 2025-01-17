/*
REGOLE
- Tutte le risposte devono essere scritte in JavaScript
- Puoi usare Google / StackOverflow ma solo quanto ritieni di aver bisogno di qualcosa che non è stato spiegato a lezione
- Puoi testare il tuo codice in un file separato, o de-commentando un esercizio alla volta
- Per visualizzare l'output, lancia il file HTML a cui è collegato e apri la console dagli strumenti di sviluppo del browser. 
- Utilizza dei console.log() per testare le tue variabili e/o i risultati delle espressioni che stai creando.
*/

/* ESERCIZIO 1
    Dato il seguente array, scrivi del codice per stampare ogni elemento dell'array in console.
*/
const pets1 = ['dog', 'cat', 'hamster', 'redfish']

console.log(pets1)

/* ESERCIZIO 2
    Scrivi del codice per ordinare alfabeticamente gli elementi dell'array "pets".
*/
const pets2 = ['dog', 'cat', 'hamster', 'redfish']
pets2.sort()
console.log(pets2)


/* ESERCIZIO 3
    Scrivi del codice per stampare nuovamente in console gli elementi dell'array "pets", questa volta in ordine invertito.
*/
const pets3 = ['dog', 'cat', 'hamster', 'redfish']
pets3.reverse()
console.log(pets3)

/* ESERCIZIO 4
    Scrivi del codice per spostare il primo elemento dall'array "pets" in ultima posizione.
*/
const pets4 = ['dog', 'cat', 'hamster', 'redfish']
pets4.shift()
pets4.push('readfish')
console.log(pets4)

/* ESERCIZIO 5
    Dato il seguente array di oggetti, scrivi del codice per aggiungere ad ognuno di essi una proprietà "licensePlate" con valore a tua scelta.
*/
const cars = [
  {
    brand: 'Ford',
    model: 'Fiesta',
    color: 'red',
    trims: ['titanium', 'st', 'active'],
    licensePlate: 'AQ234N'
  },
  {
    brand: 'Peugeot',
    model: '208',
    color: 'blue',
    trims: ['allure', 'GT'],
    licensePlate: 'BA748M'
  },
  {
    brand: 'Volkswagen',
    model: 'Polo',
    color: 'black',
    trims: ['life', 'style', 'r-line'],
    licensePlate: 'VN027B'
  },
]

console.log(cars)

/* ESERCIZIO 6
    Scrivi del codice per aggiungere un nuovo oggetto in ultima posizione nell'array "cars", rispettando la struttura degli altri elementi.
    Successivamente, rimuovi l'ultimo elemento della proprietà "trims" da ogni auto.
*/
cars.details = []
let passaggio

for(let i = 0; i < cars.length; i ++)
{

  passaggio = cars[i].trims
  passaggio.pop()
}

console.log(cars)

/* ESERCIZIO 7
    Scrivi del codice per salvare il primo elemento della proprietà "trims" di ogni auto nel nuovo array "justTrims", sotto definito.
*/
const justTrims = []

//se invece lo voglio come proprieta nuova di cars fraccio cosi:
//cars.justTrims = []

let passaggio2

for(let i = 0; i < cars.length; i ++)
{
  passaggio2 = cars[i].trims[0]
  justTrims.push(passaggio2)

  //se lo messo come nuova proprieta per pushare dentro il valore di passaggio2 devo fare cosi:
  //cars.justTrims.push(passaggio2)
}

console.log(justTrims)

//per vedere tutto il contenuto
//console.log(cars)

/* ESERCIZIO 8
    Cicla l'array "cars" e costruisci un if/else statament per mostrare due diversi messaggi in console. Se la prima lettera della proprietà
    "color" ha valore "b", mostra in console "Fizz". Altrimenti, mostra in console "Buzz".
*/

for(let i = 0; i < cars.length; i++) 
{
  if(cars[i].color.charAt(0) === 'b')
  {
    console.log('Fizz')
  }
  else{
    console.log('Buzz')
  }
}

/* ESERCIZIO 9
    Utilizza un ciclo while per stampare in console i valori del seguente array numerico fino al raggiungimento del numero 32.
*/
const numericArray = [
  6, 90, 45, 75, 84, 98, 35, 74, 31, 2, 8, 23, 100, 32, 66, 313, 321, 105,
]

let i = 0


while (i < numericArray.length) 
{
  console.log(numericArray[i])
  
  if (numericArray[i] === 32) 
  {
    break
  }
  
  i++
}

/*in alternativi posso per ottimizzare ed evitare di stampare righe inutili posso consologgare un array con quei valori:

let numeriValidi = []

while (i < numericArray.length) 
  {
    numeriValidi.push(numericArray[i])
    
    if (numericArray[i] === 32) 
    {
      break
    }
    
    i++
  }

console.log(numeriValidi)*/

/* ESERCIZIO 10
    Partendo dall'array fornito e utilizzando un costrutto switch, genera un nuovo array composto dalle posizioni di ogni carattere all'interno
    dell'alfabeto italiano.
    es. [f, b, e] --> [6, 2, 5]
*/
const charactersArray = ['g', 'n', 'u', 'z', 'd'];
const positionsArray = [];

for (let i = 0; i < charactersArray.length; i++) 
{
    switch (charactersArray[i]) {
        case 'a':
            positionsArray.push(1);
            break
        case 'b':
            positionsArray.push(2);
            break
        case 'c':
            positionsArray.push(3);
            break
        case 'd':
            positionsArray.push(4);
            break
        case 'e':
            positionsArray.push(5);
            break
        case 'f':
            positionsArray.push(6);
            break
        case 'g':
            positionsArray.push(7);
            break
        case 'h':
            positionsArray.push(8);
            break
        case 'i':
            positionsArray.push(9);
            break
        case 'l':
            positionsArray.push(10);
            break
        case 'm':
            positionsArray.push(11);
            break
        case 'n':
            positionsArray.push(12);
            break
        case 'o':
            positionsArray.push(13);
            break
        case 'p':
            positionsArray.push(14);
            break
        case 'q':
            positionsArray.push(15);
            break
        case 'r':
            positionsArray.push(16);
            break
        case 's':
            positionsArray.push(17);
            break
        case 't':
            positionsArray.push(18);
            break
        case 'u':
            positionsArray.push(19);
            break
        case 'v':
            positionsArray.push(20);
            break
        case 'z':
            positionsArray.push(21);
            break
        default:
            // Se il carattere non è nell'alfabeto italiano, non facciamo nulla
            break
    }
}

console.log(positionsArray)