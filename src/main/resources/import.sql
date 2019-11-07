-- user
INSERT INTO users (user_name, password, created_at, updated_at, role) VALUES ('admin', '$2a$04$YDiv9c./ytEGZQopFfExoOgGlJL6/o0er0K.hiGb5TGKHUL8Ebn..', NOW(), NOW(), 'ROLE_ADMIN') ON CONFLICT DO NOTHING;

-- recipe
INSERT INTO recipes (title, description, body, created_by_id, created_at, updated_by_id, updated_at) VALUES ('Füstölt szárazkolbász', 'random description', '...', 1, NOW(), 1, NOW());
INSERT INTO recipes (title, description, body, created_by_id, created_at, updated_by_id, updated_at) VALUES ('Füstölt szárazkolbász 2', 'random description 2', '...', 1, NOW(), 1, NOW());

-- label
INSERT INTO labels (label, created_by_id, created_at, updated_by_id, updated_at) VALUES ('NYERS VEGÁN', 1, NOW(), 1, NOW());

-- recipe label kapcsolat
INSERT INTO recipes_label (recipes_id, label_id) VALUES (1, 1);
INSERT INTO recipes_label (recipes_id, label_id) VALUES (2, 1);
