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
    override func viewDidLoad() {
        super.viewDidLoad();
        scrollview.delegate = self
        
        // Do any additional setup after loading the view.
        let color1 = UIColor(red: 0.2352941176, green: 0.6823529412, blue: 0.6392156863, alpha: 1)
        let color2 = UIColor(red: 0.1254901961, green: 0.3882352941, blue: 0.6078431373, alpha: 1)
        view.setGradientBackground(colorTop: color1, colorBottom: color2)
        

        
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
        slide1.titleText.text = "دست های خود را شسته وخشک نمایید"
        
        
        let slide2:SlideItem = Bundle.main.loadNibNamed("SlideItem", owner: self, options: nil)?.first as! SlideItem;
        slide2.imageContainer.image = #imageLiteral(resourceName: "Main-color")
        slide2.titleText.text = "دستگاه گلوکومتر خود را حاضر کنید، هر دستگاه تفاوت های جزئی خاص خود را دارد ،دستورالعمل ونحوه کارکردن با آن را با دقت مطالعه کنید. در ابتدا بهتر است تحت نظر یک پرستار آموزش دهنده دیابت این کارراانجام دهید"
        
        let slide3:SlideItem = Bundle.main.loadNibNamed("SlideItem", owner: self, options: nil)?.first as! SlideItem;
        slide3.imageContainer.image = #imageLiteral(resourceName: "Main-color")
        slide3.titleText.text = "محل مورد نظر برای خون گرفتن را مشخص کنید، برای این کار همیشه از یک نقطه ثابت استفاده نکنید، بهتر است هربار یک انگشت را انتخاب کنید"
        
        let slide4:SlideItem = Bundle.main.loadNibNamed("SlideItem", owner: self, options: nil)?.first as! SlideItem;
        slide4.imageContainer.image = #imageLiteral(resourceName: "Main-color")
        slide4.titleText.text = "سوزن وقلم را آماده نمایید. درست مثل دستگاه های گلوکومتر،قلم ها نیز تفاوت هایی با هم دارند . دستورالعمل کار با قلم را خوانده وبا دقت آنرا اجرا کنید"
        
           let slide5:SlideItem = Bundle.main.loadNibNamed("SlideItem", owner: self, options: nil)?.first as! SlideItem;
        slide5.imageContainer.image = #imageLiteral(resourceName: "Main-color")
        slide5.titleText.text = "قلم را مقابل انگشتتان قرار داده و آن را به سمت انگشت فشار دهید"
        let slide6:SlideItem = Bundle.main.loadNibNamed("SlideItem", owner: self, options: nil)?.first as! SlideItem;
        slide6.imageContainer.image =  #imageLiteral(resourceName: "cheap-balini")
        slide6.titleText.text = "با کمی فشاردادن قطره ای خون خارج می شود،اگر خون خارج نمی شود دست خود را به سمت پایین گرفته و به آرامی انگشت را فشار دهید"
        
        let slide7:SlideItem = Bundle.main.loadNibNamed("SlideItem", owner: self, options: nil)?.first as! SlideItem;
         slide7.imageContainer.image =  #imageLiteral(resourceName: "cheap-balini")
        
        slide7.titleText.text = "قطره خون را روی نوار اندازه گیری قند قرار دهید و آن را در دستگاه گذاشته و منتظر بمانید تا نتیجه روی صفحه دستگاه ظاهر شود"
        let slide8:SlideItem = Bundle.main.loadNibNamed("SlideItem", owner: self, options: nil)?.first as! SlideItem;
        slide8.imageContainer.image =  #imageLiteral(resourceName: "cheap-balini")
        slide8.titleText.text = "نتیجه را در قسمت چکاپ ثبت نمایید"
        return [slide1,slide2,slide3,slide4,slide5,slide6,slide7,slide8]
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
 
        
        
    }
    
    
}

