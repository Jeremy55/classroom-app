<?php

namespace App\Form;

use App\Entity\Classroom;
use App\Entity\Galery;
use Symfony\Bridge\Doctrine\Form\Type\EntityType;
use Symfony\Component\Form\AbstractType;
use Symfony\Component\Form\FormBuilderInterface;
use Symfony\Component\OptionsResolver\OptionsResolver;

class GaleryType extends AbstractType
{
    public function buildForm(FormBuilderInterface $builder, array $options): void
    {
        $builder
            ->add('name')
            ->add('classroom', EntityType::class, [
                'class' => Classroom::class,
                'choice_label' => function ($classroom) {
                    return $classroom->getName();
                }
            ]);
        ;
    }

    public function configureOptions(OptionsResolver $resolver): void
    {
        $resolver->setDefaults([
            'data_class' => Galery::class,
        ]);
    }
}
