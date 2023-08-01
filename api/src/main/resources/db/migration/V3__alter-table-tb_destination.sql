ALTER TABLE tb_destination
    RENAME COLUMN picture TO first_picture,
    ADD COLUMN(second_picture VARCHAR(2048)),
    ADD COLUMN(meta VARCHAR(160)),
    ADD COLUMN(descritive_text TEXT),
    DROP COLUMN price;
