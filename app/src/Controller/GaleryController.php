<?php

namespace App\Controller;

use App\Entity\Galery;
use App\Form\GaleryType;
use App\Repository\GaleryRepository;
use Doctrine\ORM\EntityManagerInterface;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;

#[Route('/galery')]
class GaleryController extends AbstractController
{
    #[Route('/', name: 'galery_index', methods: ['GET'])]
    public function index(GaleryRepository $galeryRepository): Response
    {
        return $this->render('galery/index.html.twig', [
            'galeries' => $galeryRepository->findAll(),
        ]);
    }

    #[Route('/new', name: 'galery_new', methods: ['GET', 'POST'])]
    public function new(Request $request, EntityManagerInterface $entityManager): Response
    {
        $galery = new Galery();
        $form = $this->createForm(GaleryType::class, $galery);
        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid()) {
            $entityManager->persist($galery);
            $entityManager->flush();

            return $this->redirectToRoute('galery_index', [], Response::HTTP_SEE_OTHER);
        }

        return $this->renderForm('galery/new.html.twig', [
            'galery' => $galery,
            'form' => $form,
        ]);
    }

    #[Route('/{id}', name: 'galery_show', methods: ['GET'])]
    public function show(Galery $galery): Response
    {
        return $this->render('galery/show.html.twig', [
            'galery' => $galery,
        ]);
    }

    #[Route('/{id}/edit', name: 'galery_edit', methods: ['GET', 'POST'])]
    public function edit(Request $request, Galery $galery, EntityManagerInterface $entityManager): Response
    {
        $form = $this->createForm(GaleryType::class, $galery);
        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid()) {
            $entityManager->flush();

            return $this->redirectToRoute('galery_index', [], Response::HTTP_SEE_OTHER);
        }

        return $this->renderForm('galery/edit.html.twig', [
            'galery' => $galery,
            'form' => $form,
        ]);
    }

    #[Route('/{id}', name: 'galery_delete', methods: ['POST'])]
    public function delete(Request $request, Galery $galery, EntityManagerInterface $entityManager): Response
    {
        if ($this->isCsrfTokenValid('delete'.$galery->getId(), $request->request->get('_token'))) {
            $entityManager->remove($galery);
            $entityManager->flush();
        }

        return $this->redirectToRoute('galery_index', [], Response::HTTP_SEE_OTHER);
    }
}
