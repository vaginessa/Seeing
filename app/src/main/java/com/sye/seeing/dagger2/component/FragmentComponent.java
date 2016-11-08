package com.sye.seeing.dagger2.component;

import com.sye.seeing.dagger2.Fragment;
import com.sye.seeing.dagger2.module.FragmentModule;

import dagger.Component;

/**
 * @author Secray
 * @date 2016.11.08
 */

@Component(modules = {FragmentModule.class}, dependencies = {ActivityComponent.class})
@Fragment
public interface FragmentComponent {
}
