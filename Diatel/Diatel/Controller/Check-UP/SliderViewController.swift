//
//  SliderViewController.swift
//  Diatel
//
//  Created by M.A.R.G on 2/7/1398 AP.
//  Copyright © 1398 MohamedRezaGhate. All rights reserved.
//

import UIKit

class SliderViewController: UIViewController,UIScrollViewDelegate {
    
    @IBOutlet weak var scrollview: UIScrollView!
    @IBOutlet weak var pager: UIPageControl!
    var slideitems:[SlideItem] = [];
    let colors = [#colorLiteral(red: 0.8646191359, green: 0.004884520546, blue: 0.3248561621, alpha: 1),#colorLiteral(red: 0.2452431619, green: 0.6648419499, blue: 0.6046652794, alpha: 1),#colorLiteral(red: 0.9352757335, green: 0.2873588502, blue: 0.29219383, alpha: 1),#colorLiteral(red: 0.8274509804, green: 0.6705882353, blue: 0.2980392157, alpha: 1)]
    override func viewDidLoad() {
        super.viewDidLoad();
        scrollview.delegate = self
        
        // Do any additional setup after loading the view.
        self.view.backgroundColor = colors[0]
        
        slideitems = createslide();
        setupSlideScrollView(slides: slideitems)
        
        pager.numberOfPages = slideitems.count;
        pager.currentPage = 0
    }
    
    
    
    //MARK:Setup Scrollview Slides
    /**********************************************************/
    
    
    func createslide() -> [SlideItem]{
        
        let slide1:SlideItem = Bundle.main.loadNibNamed("SlideItem", owner: self, options: nil)?.first as! SlideItem;
        slide1.imageContainer.image = #imageLiteral(resourceName: "Main-color")
        slide1.titleText.text = "اطلاعات کامل و بروز پزشکان به تفکیک شهر و تخصص"
        
        
        let slide2:SlideItem = Bundle.main.loadNibNamed("SlideItem", owner: self, options: nil)?.first as! SlideItem;
        slide2.imageContainer.image = #imageLiteral(resourceName: "Main-color")
        slide2.titleText.text = "پوشش تمامی پزشکان خوزستان در تمامی تخصص ها اطلاعات کامل دارویی و دسته بندی شده از منابع رسمی و داخلی"
        
        let slide3:SlideItem = Bundle.main.loadNibNamed("SlideItem", owner: self, options: nil)?.first as! SlideItem;
        slide3.imageContainer.image = #imageLiteral(resourceName: "Main-color")
        slide3.titleText.text = "تفسیر کامل اطلاعات موجود در آزمایش شما و پاسخگویی در کمترین زمان ممکن"
        
        let slide4:SlideItem = Bundle.main.loadNibNamed("SlideItem", owner: self, options: nil)?.first as! SlideItem;
        slide4.imageContainer.image = #imageLiteral(resourceName: "Main-color")
        slide4.titleText.text = "یادآوری داروی شما راس ساعات و تاریخ  با استفاده از سیستم هشدار پیشرفته"
        
        return [slide1,slide2,slide3,slide4]
    }
    
    func setupSlideScrollView(slides : [SlideItem]) {
        scrollview.frame = CGRect(x: 0, y: 0, width: view.frame.width, height: view.frame.height)
        scrollview.contentSize = CGSize(width: view.frame.width * CGFloat(slides.count), height: view.frame.height)
        scrollview.isPagingEnabled = true
        
        for i in 0 ..< slides.count {
            slides[i].frame = CGRect(x: view.frame.width * CGFloat(i), y: 0, width: view.frame.width, height: view.frame.height)
            scrollview.addSubview(slides[i])
        }
    }
    
    
    func scrollViewDidEndDecelerating(_ scrollView: UIScrollView) {
        
        let contentofset = (scrollView.contentOffset.x/scrollView.frame.width)
        pager.currentPage = Int(contentofset);
        UIView.animate(withDuration: 0.2) {
            self.view.backgroundColor = self.colors[Int(contentofset)]
        }
        
        
    }
    
    
}

