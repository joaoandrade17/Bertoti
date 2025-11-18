const API_BASE_URL = 'http://localhost:8080/movies';

// Elementos do DOM
const movieForm = document.getElementById('movieForm');
const movieTitle = document.getElementById('movieTitle');
const movieGenre = document.getElementById('movieGenre');
const movieYear = document.getElementById('movieYear');
const movieRating = document.getElementById('movieRating');
const moviesList = document.getElementById('moviesList');
const totalMoviesEl = document.getElementById('totalMovies');
const avgRatingEl = document.getElementById('avgRating');

// Função para gerar UUID
function generateUUID() {
    return 'xxxxxxxx-xxxx-4xxx-yxxx-xxxxxxxxxxxx'.replace(/[xy]/g, function(c) {
        const r = Math.random() * 16 | 0;
        const v = c === 'x' ? r : (r & 0x3 | 0x8);
        return v.toString(16);
    });
}

// Carregar filmes ao carregar a página
document.addEventListener('DOMContentLoaded', () => {
    loadMovies();
});

// Adicionar novo filme
movieForm.addEventListener('submit', (e) => {
    e.preventDefault();
    
    const newMovie = {
        id: generateUUID(),
        title: movieTitle.value.trim(),
        genre: movieGenre.value,
        year: parseInt(movieYear.value),
        rating: parseInt(movieRating.value)
    };

    axios.post(API_BASE_URL, newMovie)
        .then(response => {
            movieForm.reset();
            loadMovies();
        })
        .catch(error => {
            console.error('Erro ao adicionar filme:', error);
            alert('Erro ao adicionar filme. Tente novamente.');
        });
});

// Carregar todos os filmes
function loadMovies() {
    axios.get(API_BASE_URL)
        .then(response => {
            displayMovies(response.data);
            updateStats(response.data);
        })
        .catch(error => {
            console.error('Erro ao carregar filmes:', error);
        });
}

// Exibir filmes na tela
function displayMovies(movies) {
    moviesList.innerHTML = '';

    if (movies.length === 0) {
        moviesList.innerHTML = '<div class="empty-state">Nenhum filme cadastrado. Adicione seu primeiro filme acima!</div>';
        return;
    }

    // Ordenar por ano (mais recentes primeiro)
    const sortedMovies = [...movies].sort((a, b) => b.year - a.year);

    sortedMovies.forEach(movie => {
        const movieCard = createMovieCard(movie);
        moviesList.appendChild(movieCard);
    });
}

// Criar card HTML para um filme
function createMovieCard(movie) {
    const card = document.createElement('div');
    card.className = 'movie-card';
    card.setAttribute('data-id', movie.id);

    const stars = '⭐'.repeat(movie.rating) + '☆'.repeat(5 - movie.rating);

    card.innerHTML = `
        <div class="movie-card-header">
            <h3 class="movie-title">${escapeHtml(movie.title)}</h3>
            <div class="movie-rating">${stars}</div>
        </div>
        <div class="movie-card-body">
            <div class="movie-info">
                <span class="movie-genre">${escapeHtml(movie.genre)}</span>
                <span class="movie-year">${movie.year}</span>
            </div>
        </div>
        <div class="movie-card-actions">
            <button class="btn-edit" onclick="editMovie('${movie.id}')" title="Editar">
                ✏️ Editar
            </button>
            <button class="btn-delete" onclick="deleteMovie('${movie.id}')" title="Excluir">
                🗑️ Excluir
            </button>
        </div>
    `;

    return card;
}

// Editar filme
function editMovie(movieId) {
    axios.get(`${API_BASE_URL}/${movieId}`)
        .then(response => {
            const movie = response.data;
            
            const newTitle = prompt('Título do filme:', movie.title);
            if (newTitle === null) return;

            const newGenre = prompt('Gênero:', movie.genre);
            if (newGenre === null) return;

            const newYear = prompt('Ano de lançamento:', movie.year);
            if (newYear === null) return;

            const newRating = prompt('Avaliação (1-5):', movie.rating);
            if (newRating === null) return;

            if (newTitle.trim() && newGenre.trim() && newYear && newRating) {
                movie.title = newTitle.trim();
                movie.genre = newGenre.trim();
                movie.year = parseInt(newYear);
                movie.rating = parseInt(newRating);

                if (movie.rating < 1) movie.rating = 1;
                if (movie.rating > 5) movie.rating = 5;

                return axios.put(`${API_BASE_URL}/${movieId}`, movie);
            }
        })
        .then(response => {
            if (response) {
                loadMovies();
            }
        })
        .catch(error => {
            console.error('Erro ao editar filme:', error);
            alert('Erro ao editar filme. Tente novamente.');
        });
}

// Excluir filme
function deleteMovie(movieId) {
    if (confirm('Tem certeza que deseja excluir este filme?')) {
        axios.delete(`${API_BASE_URL}/${movieId}`)
            .then(() => {
                loadMovies();
            })
            .catch(error => {
                console.error('Erro ao excluir filme:', error);
                alert('Erro ao excluir filme. Tente novamente.');
            });
    }
}

// Atualizar estatísticas
function updateStats(movies) {
    const total = movies.length;
    const avgRating = total > 0 
        ? (movies.reduce((sum, m) => sum + m.rating, 0) / total).toFixed(1)
        : 0.0;

    totalMoviesEl.textContent = total;
    avgRatingEl.textContent = avgRating;
}

// Função auxiliar para escapar HTML
function escapeHtml(text) {
    const div = document.createElement('div');
    div.textContent = text;
    return div.innerHTML;
}
