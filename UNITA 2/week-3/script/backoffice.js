//Token Autorization: eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2NzM3MmI5ZWFlZGU3ODAwMTU3OTM0NjQiLCJpYXQiOjE3MzE2Njg4OTQsImV4cCI6MTczMjg3ODQ5NH0.vg7HJhBDqgYrxba5jiJO17s1lniZL1L4nMs8rEoJMLA
//leo@leo.com, 1234

class product {
    constructor(_name, _description, _price, _brand, _img) {
      this.name = _name
      this.description = _description
      this.price = _price
      this.brand = _brand
      this.img = _img
    }
  }

const product_url = 'https://striveschool-api.herokuapp.com/api/product/'

const addressBarContent = new URLSearchParams(window.location.search)
const productId = addressBarContent.get('productId')

if(productId)

    fetch(product_url + '/' + productId)

        .then((Response) => {
            if(Response.ok)
            {
                return Response.json()
            }
            else
            {
                throw new Error('Errore nel recupero dettagli per pre-popolazione form')
            }
        })

        .then((singleProduct) => {
            document.getElementById('name').value = singleProduct.name
            document.getElementById('description').value = singleProduct.description
            document.getElementById('price').value = singleProduct.price
            document.getElementById('brand').value = singleProduct.brand
            document.getElementById('immagine').value = singleProduct.img
        })

fetch(product_url, {
        headers: {
        "Authorization": "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2NzM3MmI5ZWFlZGU3ODAwMTU3OTM0NjQiLCJpYXQiOjE3MzE2Njg4OTQsImV4cCI6MTczMjg3ODQ5NH0.vg7HJhBDqgYrxba5jiJO17s1lniZL1L4nMs8rEoJMLA"
    },
})
