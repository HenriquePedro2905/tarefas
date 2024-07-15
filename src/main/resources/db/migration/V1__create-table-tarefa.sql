    CREATE TABLE tarefas(
        id SERIAL PRIMARY KEY UNIQUE NOT NULL,
        name TEXT,
        description TEXT NOT NULL,
        date_conclusion DATE,
        status BOOLEAN,
        priority TEXT
    );