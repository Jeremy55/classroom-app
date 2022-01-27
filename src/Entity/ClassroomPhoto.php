<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;
use Symfony\Component\Serializer\Annotation\Groups;

/**
 * @ORM\Entity
 */
class ClassroomPhoto
{
    /**
     * @ORM\Id
     * @ORM\GeneratedValue
     * @ORM\Column(type="integer")
     */
    private $id;

    /**
     * @ORM\ManyToOne(targetEntity="App\Entity\Classroom", inversedBy="photos")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="classroom_id", referencedColumnName="id")
     * })
     */
    private $classroom;

    /**
     * @ORM\ManyToOne(targetEntity="App\Entity\Photo")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="photo_id", referencedColumnName="id")
     * })
     * @Groups({"attributes_sent_in_json"})
     */
    private $photo;

    public function getId()
    {
        return $this->id;
    }

    public function getClassroom()
    {
        return $this->classroom;
    }

    public function setClassroom(Classroom $classroom): self
    {
        $this->classroom = $classroom;
        return $this;
    }

    public function getPhoto(): Photo
    {
        return $this->photo;
    }

    public function setPhoto(Photo $photo): self
    {
        $this->photo = $photo;
        return $this;
    }
}