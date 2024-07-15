    CREATE TABLE tarefas(
        id SERIAL PRIMARY KEY UNIQUE NOT NULL,
        description TEXT NOT NULL,
        date_conclusion DATE,
        status BOOLEAN
    );