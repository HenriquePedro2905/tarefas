ALTER TABLE tarefas
ADD COLUMN users_id INTEGER;

ALTER TABLE tarefas
ADD CONSTRAINT fk_users
FOREIGN KEY (users_id) REFERENCES users(id);