<?php

namespace App\Controller;

use App\Repository\ClassroomRepository;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\JsonResponse;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;

class ClassroomController extends AbstractController
{
    /**
     * @Route("/classroom", name="classroom")
     */
    public function getAll(ClassroomRepository $classroomRepository): JsonResponse
    {
        return $this->json($classroomRepository->findAll(), 200, [], ["groups" => "attributes_sent_in_json"]);
    }
}
