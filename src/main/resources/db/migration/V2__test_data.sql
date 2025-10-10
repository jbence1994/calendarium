INSERT INTO users (email, password, first_name, middle_name, last_name, phone_number)
VALUES ('anna.smith@example.com', 'hashed_pw_1', 'Anna', NULL, 'Smith', '+12025550101'),
       ('ben.johnson@example.com', 'hashed_pw_2', 'Ben', 'Edward', 'Johnson', '+12025550102'),
       ('mary.williams@example.com', 'hashed_pw_3', 'Mary', NULL, 'Williams', '+12025550103'),
       ('peter.brown@example.com', 'hashed_pw_4', 'Peter', 'James', 'Brown', '+12025550104'),
       ('susan.miller@example.com', 'hashed_pw_5', 'Susan', 'Grace', 'Miller', '+12025550105');

INSERT INTO appointments (name, start_date, end_date, description, organizer_id)
VALUES ('Project Kickoff Meeting', '2025-10-15 09:00:00', '2025-10-15 10:30:00',
        'Initial meeting with the development team to discuss goals and schedule.',
        2),
       ('Marketing Strategy Session', '2025-10-16 13:00:00', '2025-10-16 14:30:00',
        'Review of marketing plans for the next quarter.', 1),
       ('Code Review and Refactoring', '2025-10-17 15:00:00', '2025-10-17 17:00:00',
        'Backend module review and cleanup.', 2),
       ('Client Meeting - Alpha Ltd.', '2025-10-18 10:00:00', '2025-10-18 11:00:00',
        'Presentation of new product features.', 4),
       ('Team Building Night', '2025-10-20 18:00:00', '2025-10-20 23:00:00',
        'Dinner and fun evening with the whole team.', 3);

INSERT INTO appointment_participants (appointment_id, participant_id)
SELECT id, 1
FROM appointments
WHERE name = 'Project Kickoff Meeting';
INSERT INTO appointment_participants (appointment_id, participant_id)
SELECT id, 3
FROM appointments
WHERE name = 'Project Kickoff Meeting';

INSERT INTO appointment_participants (appointment_id, participant_id)
SELECT id, 4
FROM appointments
WHERE name = 'Marketing Strategy Session';
INSERT INTO appointment_participants (appointment_id, participant_id)
SELECT id, 5
FROM appointments
WHERE name = 'Marketing Strategy Session';

INSERT INTO appointment_participants (appointment_id, participant_id)
SELECT id, 2
FROM appointments
WHERE name = 'Code Review and Refactoring';
INSERT INTO appointment_participants (appointment_id, participant_id)
SELECT id, 3
FROM appointments
WHERE name = 'Code Review and Refactoring';

INSERT INTO appointment_participants (appointment_id, participant_id)
SELECT id, 1
FROM appointments
WHERE name = 'Client Meeting - Alpha Ltd.';

INSERT INTO appointment_participants (appointment_id, participant_id)
SELECT id, 4
FROM appointments
WHERE name = 'Team Building Night';
INSERT INTO appointment_participants (appointment_id, participant_id)
SELECT id, 5
FROM appointments
WHERE name = 'Team Building Night';
