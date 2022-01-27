<?php

declare(strict_types=1);

namespace DoctrineMigrations;

use Doctrine\DBAL\Schema\Schema;
use Doctrine\Migrations\AbstractMigration;

/**
 * Auto-generated Migration: Please modify to your needs!
 */
final class Version20220127100154 extends AbstractMigration
{
    public function getDescription(): string
    {
        return '';
    }

    public function up(Schema $schema): void
    {
        // this up() migration is auto-generated, please modify it to your needs
        $this->addSql('ALTER TABLE classroom DROP CONSTRAINT fk_497d309d84ccf9b6');
        $this->addSql('DROP INDEX idx_497d309d84ccf9b6');
        $this->addSql('ALTER TABLE classroom RENAME COLUMN id_person_teacher TO person_teacher_id');
        $this->addSql('ALTER TABLE classroom ADD CONSTRAINT FK_497D309D773B1D08 FOREIGN KEY (person_teacher_id) REFERENCES person (id) NOT DEFERRABLE INITIALLY IMMEDIATE');
        $this->addSql('CREATE INDEX IDX_497D309D773B1D08 ON classroom (person_teacher_id)');
        $this->addSql('ALTER TABLE classroom_photo DROP CONSTRAINT fk_78481b91c9488cba');
        $this->addSql('ALTER TABLE classroom_photo DROP CONSTRAINT fk_78481b91fa32c528');
        $this->addSql('DROP INDEX idx_78481b91fa32c528');
        $this->addSql('DROP INDEX idx_78481b91c9488cba');
        $this->addSql('ALTER TABLE classroom_photo ADD classroom_id INT DEFAULT NULL');
        $this->addSql('ALTER TABLE classroom_photo ADD photo_id INT DEFAULT NULL');
        $this->addSql('ALTER TABLE classroom_photo DROP id_classroom');
        $this->addSql('ALTER TABLE classroom_photo DROP id_photo');
        $this->addSql('ALTER TABLE classroom_photo ADD CONSTRAINT FK_78481B916278D5A8 FOREIGN KEY (classroom_id) REFERENCES classroom (id) NOT DEFERRABLE INITIALLY IMMEDIATE');
        $this->addSql('ALTER TABLE classroom_photo ADD CONSTRAINT FK_78481B917E9E4C8C FOREIGN KEY (photo_id) REFERENCES photo (id) NOT DEFERRABLE INITIALLY IMMEDIATE');
        $this->addSql('CREATE INDEX IDX_78481B916278D5A8 ON classroom_photo (classroom_id)');
        $this->addSql('CREATE INDEX IDX_78481B917E9E4C8C ON classroom_photo (photo_id)');
        $this->addSql('ALTER TABLE classroom_student DROP CONSTRAINT fk_3dd26e1bc9488cba');
        $this->addSql('ALTER TABLE classroom_student DROP CONSTRAINT fk_3dd26e1bb3056757');
        $this->addSql('DROP INDEX idx_3dd26e1bb3056757');
        $this->addSql('DROP INDEX idx_3dd26e1bc9488cba');
        $this->addSql('ALTER TABLE classroom_student ADD classroom_id INT DEFAULT NULL');
        $this->addSql('ALTER TABLE classroom_student ADD person_student_id INT DEFAULT NULL');
        $this->addSql('ALTER TABLE classroom_student DROP id_classroom');
        $this->addSql('ALTER TABLE classroom_student DROP is_person_student');
        $this->addSql('ALTER TABLE classroom_student ADD CONSTRAINT FK_3DD26E1B6278D5A8 FOREIGN KEY (classroom_id) REFERENCES classroom (id) NOT DEFERRABLE INITIALLY IMMEDIATE');
        $this->addSql('ALTER TABLE classroom_student ADD CONSTRAINT FK_3DD26E1BFD2F2C0F FOREIGN KEY (person_student_id) REFERENCES person (id) NOT DEFERRABLE INITIALLY IMMEDIATE');
        $this->addSql('CREATE INDEX IDX_3DD26E1B6278D5A8 ON classroom_student (classroom_id)');
        $this->addSql('CREATE INDEX IDX_3DD26E1BFD2F2C0F ON classroom_student (person_student_id)');
    }

    public function down(Schema $schema): void
    {
        // this down() migration is auto-generated, please modify it to your needs
        $this->addSql('CREATE SCHEMA public');
        $this->addSql('ALTER TABLE classroom DROP CONSTRAINT FK_497D309D773B1D08');
        $this->addSql('DROP INDEX IDX_497D309D773B1D08');
        $this->addSql('ALTER TABLE classroom RENAME COLUMN person_teacher_id TO id_person_teacher');
        $this->addSql('ALTER TABLE classroom ADD CONSTRAINT fk_497d309d84ccf9b6 FOREIGN KEY (id_person_teacher) REFERENCES person (id) NOT DEFERRABLE INITIALLY IMMEDIATE');
        $this->addSql('CREATE INDEX idx_497d309d84ccf9b6 ON classroom (id_person_teacher)');
        $this->addSql('ALTER TABLE classroom_photo DROP CONSTRAINT FK_78481B916278D5A8');
        $this->addSql('ALTER TABLE classroom_photo DROP CONSTRAINT FK_78481B917E9E4C8C');
        $this->addSql('DROP INDEX IDX_78481B916278D5A8');
        $this->addSql('DROP INDEX IDX_78481B917E9E4C8C');
        $this->addSql('ALTER TABLE classroom_photo ADD id_classroom INT DEFAULT NULL');
        $this->addSql('ALTER TABLE classroom_photo ADD id_photo INT DEFAULT NULL');
        $this->addSql('ALTER TABLE classroom_photo DROP classroom_id');
        $this->addSql('ALTER TABLE classroom_photo DROP photo_id');
        $this->addSql('ALTER TABLE classroom_photo ADD CONSTRAINT fk_78481b91c9488cba FOREIGN KEY (id_classroom) REFERENCES classroom (id) NOT DEFERRABLE INITIALLY IMMEDIATE');
        $this->addSql('ALTER TABLE classroom_photo ADD CONSTRAINT fk_78481b91fa32c528 FOREIGN KEY (id_photo) REFERENCES photo (id) NOT DEFERRABLE INITIALLY IMMEDIATE');
        $this->addSql('CREATE INDEX idx_78481b91fa32c528 ON classroom_photo (id_photo)');
        $this->addSql('CREATE INDEX idx_78481b91c9488cba ON classroom_photo (id_classroom)');
        $this->addSql('ALTER TABLE classroom_student DROP CONSTRAINT FK_3DD26E1B6278D5A8');
        $this->addSql('ALTER TABLE classroom_student DROP CONSTRAINT FK_3DD26E1BFD2F2C0F');
        $this->addSql('DROP INDEX IDX_3DD26E1B6278D5A8');
        $this->addSql('DROP INDEX IDX_3DD26E1BFD2F2C0F');
        $this->addSql('ALTER TABLE classroom_student ADD id_classroom INT DEFAULT NULL');
        $this->addSql('ALTER TABLE classroom_student ADD is_person_student INT DEFAULT NULL');
        $this->addSql('ALTER TABLE classroom_student DROP classroom_id');
        $this->addSql('ALTER TABLE classroom_student DROP person_student_id');
        $this->addSql('ALTER TABLE classroom_student ADD CONSTRAINT fk_3dd26e1bc9488cba FOREIGN KEY (id_classroom) REFERENCES classroom (id) NOT DEFERRABLE INITIALLY IMMEDIATE');
        $this->addSql('ALTER TABLE classroom_student ADD CONSTRAINT fk_3dd26e1bb3056757 FOREIGN KEY (is_person_student) REFERENCES person (id) NOT DEFERRABLE INITIALLY IMMEDIATE');
        $this->addSql('CREATE INDEX idx_3dd26e1bb3056757 ON classroom_student (is_person_student)');
        $this->addSql('CREATE INDEX idx_3dd26e1bc9488cba ON classroom_student (id_classroom)');
    }
}
