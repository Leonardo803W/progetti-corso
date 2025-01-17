//Token Autorization: eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2NzM3MmI5ZWFlZGU3ODAwMTU3OTM0NjQiLCJpYXQiOjE3MzE2Njg4OTQsImV4cCI6MTczMjg3ODQ5NH0.vg7HJhBDqgYrxba5jiJO17s1lniZL1L4nMs8rEoJMLA
//leo@leo.com, 1234

const apiUrl = 'https://striveschool-api.herokuapp.com/api/product/'
const token = 'eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2NzM3MmI5ZWFlZGU3ODAwMTU3OTM0NjQiLCJpYXQiOjE3MzE2Njg4OTQsImV4cCI6MTczMjg3ODQ5NH0.vg7HJhBDqgYrxba5jiJO17s1lniZL1L4nMs8rEoJMLA'

// Funzione per ottenere tutti i prodotti
function getProducts() {

    fetch(apiUrl, {
        
        headers: {
            'Authorization': `Bearer ${token}`
        }
    })

    .then(response => {
        if (!response.ok) {
            throw new Error('Errore nella risposta del server')
        }
        return response.json()
    })

    .then(products => {
        
        console.log(products)

        renderProducts(products)
    })

    .catch(error => {
        console.error('Errore:', error.message)
        alert('Errore durante il caricamento dei prodotti.')
    });
}

// Funzione per rendere i prodotti nella homepage
function renderProducts(products) {

    const productList = document.getElementById('product-list')
    productList.innerHTML = ''
    products.forEach(product => {
        const productItem = document.createElement('div')
        productItem.innerHTML = `<h2>${product.name}</h2>
                                 <p>${product.description}</p>
                                 <img src="${product.imageUrl}" alt="${product.name}">
                                 <p>${product.price} €</p>
                                 <a href="details.html?id=${product._id}">Dettagli</a>`

        productList.appendChild(productItem);
    })
}

// Funzione per aggiungere o modificare un prodotto
function saveProduct(event) {

    event.preventDefault();
    const productId = document.getElementById('productId').value

    const newProduct = {
        name: document.getElementById('name').value,
        description: document.getElementById('description').value,
        brand: document.getElementById('brand').value,
        imageUrl: document.getElementById('imageUrl').value,
        price: parseFloat(document.getElementById('price').value) 
    }    

    const method = productId ? 'PUT' : 'POST'
    const url = productId ? `${apiUrl}${productId}` : apiUrl

    fetch(url, {

        method: method,
        headers: {
            'Authorization': `Bearer ${token}`,
            'Content-Type': 'application/json'
        },

        body: JSON.stringify(newProduct)
    })

    .then(response => {

        if (response.ok) {

            alert('Prodotto salvato!');

            window.location.href = 'homepage.html'
        } 
        else 
        {
            throw new Error('Errore durante il salvataggio del prodotto.')
        }
    })

    .catch(error => {
        alert(error.message)
    })
}

// Funzione per ottenere un prodotto specifico
function getProductById(id) {

    fetch(`${apiUrl}${id}`, {
        
        headers: {
            'Authorization': `Bearer ${token}`
        }
    })

    .then(response => {

        if (!response.ok) {
            throw new Error('Errore nella risposta del server')
        }
        return response.json();
    })

    .then(product => {
        renderProductDetails(product);
    })

    .catch(error => {
        console.error('Errore:', error.message)
        alert('Errore durante il caricamento del prodotto.')
    });
}

// Funzione per rendere i dettagli del prodotto
function renderProductDetails(product) {

    const productDetail = document.getElementById('product-detail')

    productDetail.innerHTML = `<h2>${product.name}</h2>
                               <p>${product.description}</p>
                               <p>${product.brand}</p>
                               <img src="${product.imageUrl}" alt="${product.name}">
                               <p>${product.price} €</p>
                               <button onclick="deleteProduct('${product._id}')">Elimina Prodotto</button>`
}

// Funzione per eliminare un prodotto
function deleteProduct(id) {

    fetch(`${apiUrl}${id}`, {

        method: 'DELETE',
        headers: {
            'Authorization': `Bearer ${token}`
        }
    })

    .then(response => {

        if (response.ok) {
            alert('Prodotto eliminato!');
            window.location.href = 'homepage.html'
        } 
        else 
        {
            throw new Error('Errore durante l\'eliminazione del prodotto.')
        }
    })

    .catch(error => {
        alert(error.message)
    })
}

// Event listener per il form di aggiunta/modifica
document.getElementById('product-form')?.addEventListener('submit', saveProduct);

// Carica i prodotti se siamo nella homepage
if (document.getElementById('product-list')) {
    getProducts();
}

// Carica i dettagli del prodotto se siamo nella pagina di dettaglio
const queryString = window.location.search;
const urlParams = new URLSearchParams(queryString);
const productId = urlParams.get('id');
if (productId) {
    getProductById(productId);
}
