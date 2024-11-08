document.addEventListener('DOMContentLoaded', function() {
    const filterBtn = document.getElementById('filterBtn');
    const filterDropdown = document.getElementById('filterDropdown');
    const applyFilters = document.getElementById('applyFilters');

    // Mostra/nascondi la tendina dei filtri
    filterBtn.addEventListener('click', function() {
        filterDropdown.style.display = filterDropdown.style.display === 'block' ? 'none' : 'block';
    });

    // Chiudi la tendina se clicchi al di fuori di essa
    window.addEventListener('click', function(event) {
        if (!filterBtn.contains(event.target) && !filterDropdown.contains(event.target)) {
            filterDropdown.style.display = 'none';
        }
    });

    // Funzionalità per applicare i filtri
    applyFilters.addEventListener('click', function() {
        const checkboxes = filterDropdown.querySelectorAll('input[type="checkbox"]');
        const selectedFilters = [];
        checkboxes.forEach(checkbox => {
            if (checkbox.checked) {
                selectedFilters.push(checkbox.value);
            }
        });
        alert('Filtri applicati: ' + selectedFilters.join(', '));
        filterDropdown.style.display = 'none';
    });
});

document.addEventListener('DOMContentLoaded', function() {
    const arrow = document.getElementById('arrow');
    const userDropdown = document.getElementById('userDropdown');
    const settings = document.getElementById('settings');

    // Mostra/nascondi la tendina dei filtri
    arrow.addEventListener('click', function() {
        userDropdown.style.display = userDropdown.style.display === 'block' ? 'none' : 'block';
    });

    // Chiudi la tendina se clicchi al di fuori di essa
    window.addEventListener('click', function(event) {
        if (!arrow.contains(event.target) && !arrow.contains(event.target)) {
            userDropdown.style.display = 'none';
        }
    });

    // Funzionalità per applicare i filtri
    /*settings.addEventListener('click', function() {
        const checkboxes = filterDropdown.querySelectorAll('input[type="checkbox"]');
        const selectedFilters = [];
        checkboxes.forEach(checkbox => {
            if (checkbox.checked) {
                selectedFilters.push(checkbox.value);
            }
        });
        alert('Filtri applicati: ' + selectedFilters.join(', '));
        filterDropdown.style.display = 'none';
    });*/
});