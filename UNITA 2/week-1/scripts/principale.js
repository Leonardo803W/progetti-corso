const navbar = document.getElementById('top-bar');
const button = document.getElementById('started');
const header = document.getElementById('testa');

window.addEventListener('scroll', () => {
    if (window.scrollY > 0) {
        navbar.style.backgroundColor = 'white';
        header.style.backgroundColor = 'white';
        button.style.backgroundColor = '#1a8917';
    } else {
        navbar.style.backgroundColor = '#ffc017';
        header.style.backgroundColor = '#ffc017';
        button.style.backgroundColor = 'black';
    }
});