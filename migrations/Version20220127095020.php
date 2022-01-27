<?php

declare(strict_types=1);

namespace DoctrineMigrations;

use Doctrine\DBAL\Schema\Schema;
use Doctrine\Migrations\AbstractMigration;

/**
 * Auto-generated Migration: Please modify to your needs!
 */
final class Version20220127095020 extends AbstractMigration
{
    public function getDescription(): string
    {
        return '';
    }

    public function up(Schema $schema): void
    {
        // this up() migration is auto-generated, please modify it to your needs
        $this->addSql('CREATE SEQUENCE classroom_id_seq INCREMENT BY 1 MINVALUE 1 START 1');
        $this->addSql('CREATE SEQUENCE classroom_photo_id_seq INCREMENT BY 1 MINVALUE 1 START 1');
        $this->addSql('CREATE SEQUENCE classroom_student_id_seq INCREMENT BY 1 MINVALUE 1 START 1');
        $this->addSql('CREATE SEQUENCE person_id_seq INCREMENT BY 1 MINVALUE 1 START 1');
        $this->addSql('CREATE SEQUENCE photo_id_seq INCREMENT BY 1 MINVALUE 1 START 1');
        $this->addSql('CREATE TABLE classroom (id INT NOT NULL, name VARCHAR(255) NOT NULL, ID_PERSON_TEACHER INT DEFAULT NULL, PRIMARY KEY(id))');
        $this->addSql('CREATE INDEX IDX_497D309D84CCF9B6 ON classroom (ID_PERSON_TEACHER)');
        $this->addSql('CREATE TABLE classroom_photo (id INT NOT NULL, id_classroom INT DEFAULT NULL, id_photo INT DEFAULT NULL, PRIMARY KEY(id))');
        $this->addSql('CREATE INDEX IDX_78481B91C9488CBA ON classroom_photo (id_classroom)');
        $this->addSql('CREATE INDEX IDX_78481B91FA32C528 ON classroom_photo (id_photo)');
        $this->addSql('CREATE TABLE classroom_student (id INT NOT NULL, id_classroom INT DEFAULT NULL, is_person_student INT DEFAULT NULL, PRIMARY KEY(id))');
        $this->addSql('CREATE INDEX IDX_3DD26E1BC9488CBA ON classroom_student (id_classroom)');
        $this->addSql('CREATE INDEX IDX_3DD26E1BB3056757 ON classroom_student (is_person_student)');
        $this->addSql('CREATE TABLE person (id INT NOT NULL, first_name VARCHAR(255) NOT NULL, last_name VARCHAR(255) NOT NULL, PRIMARY KEY(id))');
        $this->addSql('CREATE TABLE photo (id INT NOT NULL, name VARCHAR(255) NOT NULL, PRIMARY KEY(id))');
        $this->addSql('CREATE TABLE messenger_messages (id BIGSERIAL NOT NULL, body TEXT NOT NULL, headers TEXT NOT NULL, queue_name VARCHAR(255) NOT NULL, created_at TIMESTAMP(0) WITHOUT TIME ZONE NOT NULL, available_at TIMESTAMP(0) WITHOUT TIME ZONE NOT NULL, delivered_at TIMESTAMP(0) WITHOUT TIME ZONE DEFAULT NULL, PRIMARY KEY(id))');
        $this->addSql('CREATE INDEX IDX_75EA56E0FB7336F0 ON messenger_messages (queue_name)');
        $this->addSql('CREATE INDEX IDX_75EA56E0E3BD61CE ON messenger_messages (available_at)');
        $this->addSql('CREATE INDEX IDX_75EA56E016BA31DB ON messenger_messages (delivered_at)');
        $this->addSql('CREATE OR REPLACE FUNCTION notify_messenger_messages() RETURNS TRIGGER AS $$
            BEGIN
                PERFORM pg_notify(\'messenger_messages\', NEW.queue_name::text);
                RETURN NEW;
            END;
        $$ LANGUAGE plpgsql;');
        $this->addSql('DROP TRIGGER IF EXISTS notify_trigger ON messenger_messages;');
        $this->addSql('CREATE TRIGGER notify_trigger AFTER INSERT OR UPDATE ON messenger_messages FOR EACH ROW EXECUTE PROCEDURE notify_messenger_messages();');
        $this->addSql('ALTER TABLE classroom ADD CONSTRAINT FK_497D309D84CCF9B6 FOREIGN KEY (ID_PERSON_TEACHER) REFERENCES person (id) NOT DEFERRABLE INITIALLY IMMEDIATE');
        $this->addSql('ALTER TABLE classroom_photo ADD CONSTRAINT FK_78481B91C9488CBA FOREIGN KEY (id_classroom) REFERENCES classroom (id) NOT DEFERRABLE INITIALLY IMMEDIATE');
        $this->addSql('ALTER TABLE classroom_photo ADD CONSTRAINT FK_78481B91FA32C528 FOREIGN KEY (id_photo) REFERENCES photo (id) NOT DEFERRABLE INITIALLY IMMEDIATE');
        $this->addSql('ALTER TABLE classroom_student ADD CONSTRAINT FK_3DD26E1BC9488CBA FOREIGN KEY (id_classroom) REFERENCES classroom (id) NOT DEFERRABLE INITIALLY IMMEDIATE');
        $this->addSql('ALTER TABLE classroom_student ADD CONSTRAINT FK_3DD26E1BB3056757 FOREIGN KEY (is_person_student) REFERENCES person (id) NOT DEFERRABLE INITIALLY IMMEDIATE');
    }

    public function down(Schema $schema): void
    {
        // this down() migration is auto-generated, please modify it to your needs
        $this->addSql('CREATE SCHEMA public');
        $this->addSql('ALTER TABLE classroom_photo DROP CONSTRAINT FK_78481B91C9488CBA');
        $this->addSql('ALTER TABLE classroom_student DROP CONSTRAINT FK_3DD26E1BC9488CBA');
        $this->addSql('ALTER TABLE classroom DROP CONSTRAINT FK_497D309D84CCF9B6');
        $this->addSql('ALTER TABLE classroom_student DROP CONSTRAINT FK_3DD26E1BB3056757');
        $this->addSql('ALTER TABLE classroom_photo DROP CONSTRAINT FK_78481B91FA32C528');
        $this->addSql('DROP SEQUENCE classroom_id_seq CASCADE');
        $this->addSql('DROP SEQUENCE classroom_photo_id_seq CASCADE');
        $this->addSql('DROP SEQUENCE classroom_student_id_seq CASCADE');
        $this->addSql('DROP SEQUENCE person_id_seq CASCADE');
        $this->addSql('DROP SEQUENCE photo_id_seq CASCADE');
        $this->addSql('DROP TABLE classroom');
        $this->addSql('DROP TABLE classroom_photo');
        $this->addSql('DROP TABLE classroom_student');
        $this->addSql('DROP TABLE person');
        $this->addSql('DROP TABLE photo');
        $this->addSql('DROP TABLE messenger_messages');
    }
}
