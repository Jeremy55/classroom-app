<?php

namespace App\Controller;

use App\Repository\ClassroomRepository;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;

#[Route('/')]
class MainController
{

    #[Route('/', name: 'index', methods: ['GET'])]
    public function index(ClassroomRepository $classroomRepository): Response
    {
        return $this->render('index.html.twig');
    }


}