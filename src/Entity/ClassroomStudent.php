<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;
use Symfony\Component\Serializer\Annotation\Groups;

/**
 * @ORM\Entity
 */
class ClassroomStudent
{
    /**
     * @ORM\Id
     * @ORM\GeneratedValue
     * @ORM\Column(type="integer")
     */
    private $id;

    /**
     * @ORM\ManyToOne(targetEntity="App\Entity\Classroom", inversedBy="students")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="classroom_id", referencedColumnName="id")
     * })
     */
    private $classroom;

    /**
     * @ORM\ManyToOne(targetEntity="App\Entity\Person")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="person_student_id", referencedColumnName="id")
     * })
     * @Groups({"attributes_sent_in_json"})
     */
    private $student;

    public function getId()
    {
        return $this->id;
    }

    public function getClassroom()
    {
        return $this->classroom;
    }

    public function setClassroom($classroom): void
    {
        $this->classroom = $classroom;
    }

    public function getStudent()
    {
        return $this->student;
    }

    public function setStudent($student): void
    {
        $this->student = $student;
    }
}