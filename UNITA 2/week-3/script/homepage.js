const product_url = 'https://striveschool-api.herokuapp.com/api/product/'

fetch(product_url)

  .then((response) => {

    console.log('RESPONSE', response)

    if (response.ok) {
      
      return response.json()

    } else {
      
      throw new Error('Errore nel recupero della risposta dal server')
    }
  })
  .then((arrayOfProduct) => {

    console.log('arrayOfProduct', arrayOfProduct)
    
    const row = document.getElementById('concerts-row')

    arrayOfProduct.forEach((product) => {
      const newCol = document.createElement('div')
      newCol.classList.add('col', 'col-12', 'col-md-6', 'col-lg-4')
      newCol.innerHTML = `
            <div class="card">
                <img src=" " ${product.img} class="card-img-top" alt="foto VideoGames">
                <div class="card-body">
                    <h5 class="card-title">${product.name}</h5>
                    <p class="card-text">${product.description}</p>
                    <p class="card-text">${product.brand}</p>
                    <p class="card-text">${product.price}€
      }</p>
                    <a href="./details.html?productId=${
                        product._id
                    }" class="btn btn-primary">Vai ai dettagli!</a>
                </div>
            </div>
        `
      row.appendChild(newCol)
    })
  })
  .catch((error) => {
    console.log('ERROR', error)
  })