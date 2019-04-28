//
//  PageViewController.swift
//  Diatel
//
//  Created by M.A.R.G on 2/8/1398 AP.
//  Copyright © 1398 MohamedRezaGhate. All rights reserved.
//

import UIKit

class PageViewController: UIPageViewController,UIPageViewControllerDelegate,UIPageViewControllerDataSource {
    

    lazy var Viewcontrollersforpageview : [UIViewController] = {
        let vc1 = storyboard?.instantiateViewController(withIdentifier: "first") as! FirstViewController
        let vc2 = storyboard?.instantiateViewController(withIdentifier: "second") as! SecondViewController
        let vc3 = storyboard?.instantiateViewController(withIdentifier: "third") as! ThirdViewController
        let vc4 = storyboard?.instantiateViewController(withIdentifier: "forth") as! ForthViewController
        
        return [vc1,vc2,vc3,vc4]
    }()
  
    
    override func viewDidLoad() {
        super.viewDidLoad()
        self.delegate = self;
        self.dataSource = self;
        
        if let firstviewcontroller = Viewcontrollersforpageview.first{
            setViewControllers([firstviewcontroller], direction: .forward, animated: true, completion: nil)
        }
        
        
        
    }
    
    
    override func viewDidDisappear(_ animated: Bool) {
        super.viewDidAppear(animated)
        print(viewControllers![0])
    }
    
    func pageViewController(_ pageViewController: UIPageViewController, viewControllerBefore viewController: UIViewController) -> UIViewController? {
        guard let currentindex = Viewcontrollersforpageview.index(of: viewController) else{
            return nil
        }
        let previousIndex = currentindex - 1
        
        guard previousIndex >= 0 else{
            return nil
        }
        guard Viewcontrollersforpageview.count > previousIndex else{
            return nil
        }
        return Viewcontrollersforpageview[previousIndex]
        
    }
    
    func pageViewController(_ pageViewController: UIPageViewController, viewControllerAfter viewController: UIViewController) -> UIViewController? {
        guard let currentindex = Viewcontrollersforpageview.index(of: viewController) else{
            return nil
        }
        let nextIndex = currentindex + 1
        
        guard Viewcontrollersforpageview.count != nextIndex else{
            return nil
        }
        
        guard Viewcontrollersforpageview.count > nextIndex else{
            return nil
        }
        return Viewcontrollersforpageview[nextIndex]
    }
    
    

    
    
    
}


//extention for going to next page
extension UIPageViewController {
    func goToNextPage(animated: Bool = true, completion: ((Bool) -> Void)? = nil) {
        if let currentViewController = viewControllers?[0] {
            if let nextPage = dataSource?.pageViewController(self, viewControllerAfter: currentViewController){
                setViewControllers([nextPage], direction: .forward, animated: animated, completion: completion)
            }
        }
    }
    
    
}
//enable or disable scroll behavior from pagecontroller
extension UIPageViewController {
    var isPagingEnabled: Bool {
        get {
            var isEnabled: Bool = true
            for view in view.subviews {
                if let subView = view as? UIScrollView {
                    isEnabled = subView.isScrollEnabled
                }
            }
            return isEnabled
        }
        set {
            for view in view.subviews {
                if let subView = view as? UIScrollView {
                    subView.isScrollEnabled = newValue
                }
            }
        }
    }
}
