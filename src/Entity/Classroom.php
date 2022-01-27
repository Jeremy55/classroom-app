<?php

namespace App\Entity;

use App\Repository\ClassroomRepository;
use Doctrine\ORM\Mapping as ORM;
use Symfony\Component\Serializer\Annotation\Groups;

/**
 * @ORM\Entity(repositoryClass=ClassroomRepository::class)
 */
class Classroom
{
    /**
     * @ORM\Id
     * @ORM\GeneratedValue
     * @ORM\Column(type="integer")
     * @Groups({"attributes_sent_in_json"})
     */
    private $id;

    /**
     * @ORM\Column(type="string", length=255)
     * @Groups({"attributes_sent_in_json"})
     */
    private $name;

    /**
     * @ORM\ManyToOne(targetEntity="App\Entity\Person")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="person_teacher_id", referencedColumnName="id")
     * })
     * @Groups({"attributes_sent_in_json"})
     */
    private $teacher;

    /**
     * @ORM\ManyToMany(targetEntity="App\Entity\ClassroomStudent", mappedBy="classroom")
     * @Groups({"attributes_sent_in_json"})
     */
    private $students;

    /**
     * @ORM\ManyToMany(targetEntity="App\Entity\ClassroomPhoto", mappedBy="classroom")
     * @Groups({"attributes_sent_in_json"})
     */
    private $photos;

    public function getId(): ?int
    {
        return $this->id;
    }

    public function getName(): ?string
    {
        return $this->name;
    }

    public function setName(string $name): self
    {
        $this->name = $name;
        return $this;
    }

    public function getTeacher()
    {
        return $this->teacher;
    }

    public function setTeacher($teacher): void
    {
        $this->teacher = $teacher;
    }

    public function getStudents()
    {
        return $this->students;
    }

    public function getPhotos()
    {
        return $this->photos;
    }
}